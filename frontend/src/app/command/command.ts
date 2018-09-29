import {CommandType} from './CommandType';

export class Command {
  id: Number;
  unit: Number;
  type: CommandType;
  base: Number;
  target: Number;
  note: String;

  static getDescription(command: Command): String {
    let s: String = 'Unit #' + command.unit;
    s += ' ' + command.type + 's';

    switch (command.type) {
      case CommandType.HOLD:
        s += ' in ' + command.base;
        break;
      case CommandType.MOVE:
      case CommandType.TRANSPORT:
      case CommandType.SUPPORT:
        s += ' from ' + command.base + ' to ' + command.target;
        break;
      default:
        break;
    }

    return s;
  }
}
