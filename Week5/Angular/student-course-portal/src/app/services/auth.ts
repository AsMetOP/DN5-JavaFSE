import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn = true; // hardcoded for now, per the handout 
}

// isLoggedIn = false; then it will only redirect to the home page!