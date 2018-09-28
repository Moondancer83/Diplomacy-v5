import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-command',
  templateUrl: './command.component.html',
  styleUrls: ['./command.component.css']
})
export class CommandComponent implements OnInit {
  title: String = 'Commands';
  commands: String[] = [""];

  constructor() { }

  ngOnInit() {
  }

}
