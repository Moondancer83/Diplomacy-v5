import { Component, OnInit } from '@angular/core';
import {Command} from './command';
import {CommandService} from './command.service';

@Component({
  selector: 'app-command',
  templateUrl: './command.component.html',
  styleUrls: ['./command.component.css']
})
export class CommandComponent implements OnInit {
  title: String = 'Commands';
  commands: Command[];

  constructor(private service: CommandService) { }

  ngOnInit() {
    this.getCommands();
  }

  private getCommands() {
    this.service.getCommands().subscribe(c => this.commands = c);
  }

  commandDescription(command: Command): String {
    return Command.getDescription(command);
  }
}
