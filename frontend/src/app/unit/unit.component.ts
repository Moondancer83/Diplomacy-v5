import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-unit',
  templateUrl: './unit.component.html',
  styleUrls: ['./unit.component.css']
})
export class UnitComponent implements OnInit {
  title: String = 'Units';
  units: String[] = ['Royal Navy #1', 'Royal Marines #2', 'Royal Navy #3'];

  constructor() { }

  ngOnInit() {
  }

}
