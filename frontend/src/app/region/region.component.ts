import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-region',
  templateUrl: './region.component.html',
  styleUrls: ['./region.component.css']
})
export class RegionComponent implements OnInit {
  title: String = 'Regions';
  regions: String[] = ['North-Atlantic Ocean', 'Iceland'];

  constructor() { }

  ngOnInit() {
  }

}
