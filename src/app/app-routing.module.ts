import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarPessoaComponent } from './cadastrar-pessoa/cadastrar-pessoa.component';
import { EditarPessoaComponent } from './editar-pessoa/editar-pessoa.component';
import { ListarPessoasComponent } from './listar-pessoas/listar-pessoas.component';
import { BuscarPorCpfComponent } from './buscar-por-cpf/buscar-por-cpf.component';

const routes: Routes = [
  { path: '', redirectTo: '/listar', pathMatch: 'full' },
  { path: 'listar', component: ListarPessoasComponent },
  { path: 'cadastrar', component: CadastrarPessoaComponent },
  { path: 'editar/:id', component: EditarPessoaComponent },
  { path: 'buscar', component: BuscarPorCpfComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

