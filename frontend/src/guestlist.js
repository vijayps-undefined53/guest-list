import React from "react";
import { Navigation } from "./App.js";
function GuestList(props) {
  return (
    <React.Fragment>
      <Navigation value={props}></Navigation>
    </React.Fragment>
  );
}

export default GuestList;
