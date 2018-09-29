import { Component, OnInit } from '@angular/core';
import {Unit} from './unit';
import {UnitService} from './unit.service';

@Component({
  selector: 'app-unit',
  templateUrl: './unit.component.html',
  styleUrls: ['./unit.component.css']
})
export class UnitComponent implements OnInit {
  title: String = 'Units';
  units: Unit[];

  constructor(private service: UnitService) { }

  ngOnInit() {
    this.getUnits();
  }

  private getUnits() {
    this.service.getUnits().subscribe(u => this.units = u);
  }
}
