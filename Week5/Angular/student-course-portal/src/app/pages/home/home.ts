import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CourseService } from '../../services/course';
import { Notification } from '../../components/notification/notification';

@Component({
  selector: 'app-home',
  imports: [FormsModule, Notification],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit, OnDestroy {
  portalName = 'Student Course Portal';
  isPortalActive = true;
  message = '';
  searchTerm = '';
  courseCount = 0;

  constructor(private courseService: CourseService) {}

  onEnrollClick() {
    this.message = 'Enrollment opened!';
  }

  ngOnInit() {
    console.log('HomeComponent initialised — courses loaded');
    this.courseService.getCourses().subscribe({
      next: (courses) => this.courseCount = courses.length,
      error: () => this.courseCount = 0
    });
  }

  ngOnDestroy() {
    console.log('HomeComponent destroyed');
  }
}