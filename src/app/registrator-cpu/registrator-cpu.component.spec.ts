import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistratorCpuComponent } from './registrator-cpu.component';

describe('RegistratorCpuComponent', () => {
  let component: RegistratorCpuComponent;
  let fixture: ComponentFixture<RegistratorCpuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistratorCpuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistratorCpuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
