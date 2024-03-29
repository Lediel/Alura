import { Component, DoCheck, OnInit } from '@angular/core';
import { Item } from './interfaces/iItem';
import { ListaDeCompraService } from './service/lista-de-compra.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, DoCheck {
  title = 'app-lista-de-compras';
  listaDeCompra! : Array<Item>
  ItemParaSerEditado! : Item;

  constructor(private listaService: ListaDeCompraService) { }

  ngOnInit(): void {
    this.listaDeCompra = this.listaService.getListaDeCompra();
    console.log(this.listaDeCompra)
  }

  editarItem(item: Item) {
    this.ItemParaSerEditado = item;
  }

  deletarItem(id: number) {
    const index = this.listaDeCompra.findIndex((item)=>item.id === id);
    this.listaDeCompra.splice(index, 1);
  }

  limparLista() {
    this.listaService.limparLocalStorage();
    this.listaDeCompra = []
  }

  ngDoCheck(): void {
    console.log("DoCheck foi chamado")
    this.listaService.atualizarLocalStorage()
  }

}
