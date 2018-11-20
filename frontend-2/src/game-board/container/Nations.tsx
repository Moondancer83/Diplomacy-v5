import * as React from "react";
import nationResource from "../resource/nationResource";
import DataTable from "../../table/DataTable";
import Paper from "@material-ui/core/Paper/Paper";
import Typography from "@material-ui/core/Typography/Typography";

export default class Nations extends React.Component<any, any> {
  public constructor(props: any) {
    super(props);
    this.state = {
      nations: []
    };
  }

  public async componentWillMount() {
    const nations = await nationResource.getNations();
    this.setState({
      nations
    });
  }

  public render() {
    return (
      <Paper>
        <Typography variant="h3">List of Nations</Typography>
        <DataTable data={this.state.nations} />
      </Paper>
    );
  }
}
