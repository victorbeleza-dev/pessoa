import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pessoa } from '../pessoa.model';
import { PessoaService } from '../pessoa.service';

@Component({
  selector: 'app-cadastrar-pessoa',
  templateUrl: './cadastrar-pessoa.component.html',
  styleUrls: ['./cadastrar-pessoa.component.scss']
})
export class CadastrarPessoaComponent implements OnInit {
  pessoa: Pessoa = { nome: '', cpf: '' };

  constructor(private pessoaService: PessoaService, private router: Router) { }

  ngOnInit(): void {
  }

  salvar(): void {
    this.pessoaService.salvar(this.pessoa).subscribe(
      () => {
        this.router.navigate(['/listar']);
      }
    );
  }
}

