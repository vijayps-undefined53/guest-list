import React, { Component } from "react";
import "./App.css";
import { connect } from "react-redux";
import { Link } from "react-router-dom";
import { Table } from "react-bootstrap";
import { arrivalsaction } from "./Actions/arrivalsaction";
class Arrivals extends Component {
  componentDidMount() {
    this.props.arrivalsaction();
  }
  render() {
    return (
      <Table striped bordered hover size="sm">
        <thead>
          <tr>
            <th>#</th>
            <th>Guest Name</th>
            <th>Room</th>
            <th>Update</th>
          </tr>
        </thead>
        <tbody>
          {this.props.guests.map((guest, i) => {
            return (
              <tr key={i}>
                <td>{i}</td>
                <td>{guest.name}</td>
                <td>{guest.room}</td>
                <td>
                  <Link to={`updateguests/${guest.room}`}>Update Guest</Link>
                </td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    );
  }
}
const mapStateToProps = state => {
  return {
    guests: state.arrivalsReducer
  };
};
const mapDispatchToProps = () => {
  return { arrivalsaction };
};
export default connect(mapStateToProps, mapDispatchToProps())(Arrivals);
