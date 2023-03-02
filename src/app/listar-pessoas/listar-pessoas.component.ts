import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../pessoa.model';
import { PessoaService } from '../pessoa.service';

@Component({
  selector: 'app-listar-pessoas',
  templateUrl: './listar-pessoas.component.html',
  styleUrls: ['./listar-pessoas.component.scss']
})
export class ListarPessoasComponent implements OnInit {
  displayedColumns: string[] = ['Nome', 'Cpf', 'Ações'];
  pessoas: Pessoa[];

  constructor(private pessoaService: PessoaService) { }

  ngOnInit(): void {
    this.listar();
  }

  listar(): void {
    this.pessoaService.listar().subscribe(
      data => this.pessoas = data
    );
  }

  deletar(id: number): void {
    this.pessoaService.deletar(id).subscribe(
      () => {
        this.listar();
      }
    );
  }
}

