import React, { useEffect, useState, Component } from "react";
import {
  BrowserRouter as BR,
  Switch,
  Route as R,
  Link,
  useRouteMatch,
  useParams
} from "react-router-dom";
import {
  Container,
  Nav,
  Navbar,
  NavItem,
  NavbarBrand,
  NavLink,
  Jumbotron
} from "react-bootstrap";
import {
  Navigation,
  Jumbotr,
  Layout,
  Prepare,
  Arrivals,
  NoMatch
} from "./App.js";
function GuestList(props) {
  let match = useRouteMatch();
  return (
    <React.Fragment>
      <Navigation value={props}></Navigation>
    </React.Fragment>
  );
}

export default GuestList;
