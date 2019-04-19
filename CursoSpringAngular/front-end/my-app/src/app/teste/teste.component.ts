import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-teste',
  templateUrl: './teste.component.html',
  styleUrls: ['./teste.component.css']
})
export class TesteComponent implements OnInit {

  categorias: any = [];
  lancamentos: any = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  listarcategorias() {
    this.http.get('http://localhost:8080/categorias')
      .subscribe(
        result => {
          this.categorias = result;
        },
        error => {
          console.log('Faio', error);
        }
      );
  }

  listarlancamentos(){
    this.http.get('http://localhost:8080/lancamentos')
      .subscribe(
        result => {
          this.lancamentos = result;
        },
        error => {
          console.log('Falha', error);
        }
      );
  }

}
