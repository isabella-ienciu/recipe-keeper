import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { NotificationType } from '../enum/notification-type.enum';
import { User } from '../model/user';
import { AuthenticationService } from '../service/authentication.service';
import { NotificationService } from '../service/notification.service';
import { HeaderType } from '../enum/header-type.enum';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit, OnDestroy {
  public showLoading: boolean;
  private subscriptions: Subscription[] = [];

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private notifier: NotificationService
  ) {}

  ngOnInit(): void {
    if (this.authenticationService.isLoggedIn()) {
      this.router.navigateByUrl('/recipes');
    }
  }

  public onLogin(user: User): void {
    this.showLoading = true;
    console.log(user);
    this.subscriptions.push(
      this.authenticationService
        .login(user)
        .subscribe((response: HttpResponse<User> | HttpErrorResponse) => {
          if (response instanceof HttpResponse) {
            const token = response.headers.get(HeaderType.JWT_TOKEN);
            this.authenticationService.saveToken(token);
            this.authenticationService.addUserToLocalCache(response.body); //body is going to be of user type
            this.router.navigateByUrl('/recipes');
            this.showLoading = false;
          } else if (response instanceof HttpErrorResponse) {
            console.log(response);
            this.sendErrorNotification(
              NotificationType.ERROR,
              response.error.message
            );
            this.showLoading = false;
          }
        })
    );
  }
  private sendErrorNotification(
    notificationType: NotificationType,
    message: string
  ) {
    if (message) {
      this.notifier.notify(notificationType, message);
    } else {
      this.notifier.notify(
        notificationType,
        'An error occured. Please try again.'
      );
    }
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach((sub) => sub.unsubscribe);
  }
}
