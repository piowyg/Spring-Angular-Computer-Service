import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistratorGpuComponent } from './registrator-gpu.component';

describe('RegistratorGpuComponent', () => {
  let component: RegistratorGpuComponent;
  let fixture: ComponentFixture<RegistratorGpuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistratorGpuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistratorGpuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
