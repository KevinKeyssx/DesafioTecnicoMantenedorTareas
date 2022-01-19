import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopupTareasComponent } from './popup-tareas.component';

describe('PopupTareasComponent', () => {
  let component: PopupTareasComponent;
  let fixture: ComponentFixture<PopupTareasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopupTareasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PopupTareasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
