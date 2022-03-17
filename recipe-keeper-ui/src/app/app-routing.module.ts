import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RecipesComponent } from './recipes/recipes.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'recipes', component: RecipesComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' }, //order is important! empty route must be last
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
