import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../pessoa.model';
import { PessoaService } from '../pessoa.service';

@Component({
  selector: 'app-buscar-por-cpf',
  templateUrl: './buscar-por-cpf.component.html',
  styleUrls: ['./buscar-por-cpf.component.scss']
})
export class BuscarPorCpfComponent implements OnInit {
  cpf: string;
  pessoa: Pessoa;

  constructor(private pessoaService: PessoaService) { }

  ngOnInit(): void {
    console.log("PASS")
  }

  buscar(): void {
    console.log("HEEER")
    this.pessoaService.buscarPorCpf(this.cpf).subscribe(
      data => {
        console.log("PASSOU+")
        this.pessoa = data;
      },
      error => {
        console.log(error);
      }
    );
  }
}

