import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarPorCpfComponent } from './buscar-por-cpf.component';

describe('BuscarPorCpfComponent', () => {
  let component: BuscarPorCpfComponent;
  let fixture: ComponentFixture<BuscarPorCpfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuscarPorCpfComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuscarPorCpfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
