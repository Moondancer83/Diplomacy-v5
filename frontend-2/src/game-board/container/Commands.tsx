import DataTable from "../../table/DataTable";
import * as React from "react";
import Typography from "@material-ui/core/Typography/Typography";
import Paper from "@material-ui/core/Paper/Paper";
import style from "../../style/style";
import commandResource from "../resource/commandResource";

export default class Commands extends React.Component<any, any> {
  public constructor(props: any) {
    super(props);

    this.state = {
      commands: []
    };
  }

  public async componentWillMount() {
    const commands = await commandResource.getCommands();

    this.setState({
      commands
    });
  }

  public render() {
    return (
      <Paper style={style.overflow}>
        <Typography variant="h3">List of Commands</Typography>
        <DataTable data={this.state.commands} />
      </Paper>
    );
  }
}
