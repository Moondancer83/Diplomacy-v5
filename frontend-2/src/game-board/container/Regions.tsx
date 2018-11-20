import regionResource from "../resource/regionResource";
import DataTable from "../../table/DataTable";
import * as React from "react";
import Typography from "@material-ui/core/Typography/Typography";
import Paper from "@material-ui/core/Paper/Paper";
import style from "../../style/style";

export default class Regions extends React.Component<any, any> {
  public constructor(props: any) {
    super(props);

    this.state = {
      regions: []
    };
  }

  public async componentWillMount() {
    const regions = await regionResource.getRegions();

    this.setState({
      regions
    });
  }

  public render() {
    return (
      <Paper style={style.overflow}>
        <Typography variant="h3">List of Regions</Typography>
        <DataTable data={this.state.regions} />
      </Paper>
    );
  }
}
