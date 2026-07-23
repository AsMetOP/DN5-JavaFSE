import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotificationService } from '../../services/notification';

@Component({
  selector: 'app-notification',
  imports: [CommonModule],
  templateUrl: './notification.html',
  styleUrl: './notification.css',
  // Component-level provider: creates a NEW, separate instance of
  // NotificationService scoped to this component (and its children) alone,
  // instead of sharing the app-wide singleton from providedIn: 'root'.
  // This is useful when each instance of a component needs its own isolated
  // state - e.g. multiple NotificationComponents on the same page, each
  // tracking its own messages without interfering with each other.
  providers: [NotificationService],
})
export class Notification {
  constructor(private notificationService: NotificationService) {}

  get messages(): string[] {
    return this.notificationService.getMessages();
  }

  addTestMessage() {
    this.notificationService.addMessage('Test notification at ' + new Date().toLocaleTimeString());
  }
}