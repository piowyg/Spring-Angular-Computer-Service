import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistratorRamMemoryComponent } from './registrator-ram-memory.component';

describe('RegistratorRamMemoryComponent', () => {
  let component: RegistratorRamMemoryComponent;
  let fixture: ComponentFixture<RegistratorRamMemoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistratorRamMemoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistratorRamMemoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
