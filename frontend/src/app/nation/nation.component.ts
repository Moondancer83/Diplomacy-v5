import { Component, OnInit } from '@angular/core';
import { NationService } from './nation.service';
import { Nation } from './nation';

@Component({
  selector: 'app-nation',
  templateUrl: './nation.component.html',
  styleUrls: ['./nation.component.css']
})
export class NationComponent implements OnInit {
  title: String = 'Nations';
  nations: Nation[];

  constructor(private service: NationService) { }

  ngOnInit() {
    this.getNations();
  }

  private getNations() {
    this.service.getNations().subscribe(n => this.nations = n);
  }
}
