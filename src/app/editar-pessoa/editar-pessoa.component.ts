import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pessoa } from '../pessoa.model';
import { PessoaService } from '../pessoa.service';

@Component({
  selector: 'app-editar-pessoa',
  templateUrl: './editar-pessoa.component.html',
  styleUrls: ['./editar-pessoa.component.scss']
})
export class EditarPessoaComponent implements OnInit {
  pessoa: Pessoa;
  id: number;

  constructor(private pessoaService: PessoaService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.pessoaService.buscarPorId(this.id).subscribe(
      data => {
        this.pessoa = data;
      }
    );
  }

  atualizar(): void {
    this.pessoaService.atualizar(this.pessoa).subscribe(
      () => {
        this.router.navigate(['/listar']);
      }
    );
  }
}
