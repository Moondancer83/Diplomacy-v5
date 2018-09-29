import { Component, OnInit } from '@angular/core';

import { RegionService } from './region.service';
import { Region } from './region';

@Component({
  selector: 'app-region',
  templateUrl: './region.component.html',
  styleUrls: ['./region.component.css']
})
export class RegionComponent implements OnInit {
  title: String = 'Regions';
  regions: Region[];

  constructor(private service: RegionService) { }

  ngOnInit() {
    this.getRegions();
  }

  getRegions(): void {
    this.service.getRegions().subscribe(r => this.regions = r);
  }

}
