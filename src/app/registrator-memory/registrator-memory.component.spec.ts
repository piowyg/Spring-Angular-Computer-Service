import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistratorMemoryComponent } from './registrator-memory.component';

describe('RegistratorMemoryComponent', () => {
  let component: RegistratorMemoryComponent;
  let fixture: ComponentFixture<RegistratorMemoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistratorMemoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistratorMemoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
