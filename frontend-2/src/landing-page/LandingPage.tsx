import Paper from "@material-ui/core/Paper/Paper";
import Typography from "@material-ui/core/Typography/Typography";
import * as React from "react";
import { Link } from "react-router-dom";

export default class LandingPage extends React.Component {
  private readonly style: any = {
    paper: {
      margin: "50px",
      padding: "50px"
    }
  };
  public render() {
    return (
      <Paper id="landing-page-container" square={true} style={this.style.paper}>
        <Typography variant="h1">Diplomacy</Typography>
        <Typography variant="h3">
          from Allan B. Calhamer
        </Typography>

        <Typography>
            Diplomacy is a strategic board game created by Allan B. Calhamer in 1954 and released commercially in 1959.[1] Its main
            distinctions from most board wargames are its negotiation phases (players spend much of their time forming and betraying
            alliances with other players and forming beneficial strategies)[2] and the absence of dice and other game elements that
            produce random effects. Set in Europe in the years leading to the Great War, Diplomacy is played by two to seven players,
            [3] each controlling the armed forces of a major European power (or, with fewer players, multiple powers). Each player aims
            to move his or her few starting units and defeat those of others to win possession of a majority of strategic cities and
            provinces marked as "supply centers" on the map; these supply centers allow players who control them to produce more units.
            Following each round of player negotiations, each player can issue attack orders and take control of a neighboring province
            when the number of provinces adjacent to the attacking province that are given orders (written down and declared in advance)
            to support the attacking province exceeds the number of provinces adjacent to the province under attack that are given orders
            to support the province under attack.
        </Typography>

        <Link to="/auth/">Go to Dashboard</Link>
      </Paper>
    );
  }
}
