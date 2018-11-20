import Paper from "@material-ui/core/Paper/Paper";
import Typography from "@material-ui/core/Typography/Typography";
import * as React from "react";
import Nations from "../game-board/container/Nations";
import Grid from "@material-ui/core/Grid/Grid";
import Regions from "../game-board/container/Regions";
import Units from "../game-board/container/Units";
import Commands from "../game-board/container/Commands";

export default class Dashboard extends React.Component {
  public render() {
    return (
      <Grid item={true} xs={12}>
        <Paper square={true}>
          <Grid container={true} spacing={8}>
            <Grid item={true} xs={12}>
              <Typography variant="h2">Dashboard</Typography>
            </Grid>
            <Grid item={true} xs={6}>
              <Regions />
            </Grid>
            <Grid item={true} xs={6}>
              <Nations />
            </Grid>
            <Grid item={true} xs={6}>
              <Units />
            </Grid>
            <Grid item={true} xs={6}>
              <Commands />
            </Grid>
          </Grid>
        </Paper>
      </Grid>
    );
  }
}
