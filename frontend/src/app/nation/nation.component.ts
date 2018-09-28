import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nation',
  templateUrl: './nation.component.html',
  styleUrls: ['./nation.component.css']
})
export class NationComponent implements OnInit {
  title: String = 'Nations';
  nations: String[] = ['Austria-Hungary', 'England', 'France', 'Germany', 'Italy', 'Russia', 'Turkey'];

  constructor() { }

  ngOnInit() {
  }

}
