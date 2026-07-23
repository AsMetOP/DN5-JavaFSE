import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive-enrollment-form',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css',
})
export class ReactiveEnrollmentForm implements OnInit {
  enrollForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      studentEmail: ['', [Validators.required, Validators.email]],
      courseId: [null, Validators.required],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
    });
  }

  onSubmit() {
    console.log('Form value:', this.enrollForm.value);
    console.log('Raw value:', this.enrollForm.getRawValue());
    // .value excludes any disabled controls from the resulting object.
    // .getRawValue() includes every control regardless of disabled state -
    // useful when you need the full form data even if some fields are
    // temporarily disabled (e.g. read-only during editing).
  }
}