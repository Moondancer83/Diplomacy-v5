import * as React from "react";
import Table from "@material-ui/core/Table/Table";
import TableHead from "@material-ui/core/TableHead/TableHead";
import TableRow from "@material-ui/core/TableRow/TableRow";
import TableCell from "@material-ui/core/TableCell/TableCell";
import TableBody from "@material-ui/core/TableBody/TableBody";
import DataTableProps from "./DataTableProps";

export default class DataTable extends React.Component<DataTableProps, any> {
  public render(): any {
    const headers =
      this.props.data && this.props.data[0]
        ? Object.keys(this.props.data[0])
        : [];
    return this.props.data ? (
      <Table>
        <TableHead>
          <TableRow>
            {headers.map((h: string) => (
              <TableCell key={h}>{h}</TableCell>
            ))}
          </TableRow>
        </TableHead>
        <TableBody>
          {this.props.data.map((row: any, index: number) => {
            return (
              <TableRow key={index}>
                {headers.map((h: string) => (
                  <TableCell key={index + "-" + h}>
                    {this.renderCell(row[h])}
                  </TableCell>
                ))}
              </TableRow>
            );
          })}
        </TableBody>
      </Table>
    ) : null;
  }

  private renderCell(rowElement: any) {
    let result;
    if (rowElement instanceof Array) {
      result = rowElement.join(", ");
    } else {
      result = rowElement;
    }
    return result;
  }
}
