import React, { useEffect, useState } from "react";
import "./App.css";
import {
  BrowserRouter as BR,
  Route as R,
  Switch,
  Link
} from "react-router-dom";
import {
  Container,
  Nav,
  Navbar,
  NavItem,
  NavbarBrand,
  NavLink,
  Jumbotron,
  Table
} from "react-bootstrap";
import Login from "./login.js";
function App() {
  return (
    <React.Fragment>
      <BR>
        <Switch>
          <R exact path="/">
            <Login></Login>
          </R>
          <React.Fragment>
            <Navigation></Navigation>
            <Layout>
              <Switch>
                <R exact path={`/prepare`}>
                  <Jumbotr value={"prepare"}></Jumbotr>
                  <Prepare></Prepare>
                </R>
                <R exact path={`/arrivals`}>
                  <Jumbotr value={"arrivals"}></Jumbotr>
                  <Arrivals></Arrivals>
                </R>
                <R>
                  <NoMatch></NoMatch>
                </R>
              </Switch>
            </Layout>
          </React.Fragment>
        </Switch>
      </BR>
    </React.Fragment>
  );
}
const NoPage = () => (
  <div>
    Page not found for given path, use <Link to="/ ">/</Link> to login
  </div>
);
const Arrivals = () => {
  let [guests, setGuests] = useState([{}]);
  useEffect(() => {
    arrivals();
  }, []);
  let arrivals = async () => {
    await fetch(`http://localhost:8080/arrivals`)
      .then(res => res.json())
      .then(res => {
        setGuests(res);
      });
  };

  return (
    <Table striped bordered hover size="sm">
      <thead>
        <tr>
          <th>#</th>
          <th>Guest Name</th>
          <th>Room</th>
        </tr>
      </thead>
      <tbody>
        {guests.map((guest, i) => {
          return (
            <tr>
              <td>1</td>
              <td>{guest.name}</td>
              <td>{guest.room}</td>
            </tr>
          );
        })}
      </tbody>
    </Table>
  );
};
export const Prepare = () => <div>Prepare Tab </div>;
export const NoMatch = () => <div>Page not found for given path</div>;
export const NoLogin = () => <div>Not Logged In</div>;

export const Layout = props => <Container>{props.children}</Container>;
export const Navigation = props => {
  const styles = { color: "pink", backgroundColor: "grey" };
  let login = props.value;
  return { login } ? (
    <Navbar expand="lg" style={styles}>
      <Navbar.Brand href="/" style={styles}>
        Guest List
      </Navbar.Brand>
      <Navbar.Collapse>
        <Nav style={styles} className="ml-auto">
          <Nav.Item>
            <Nav.Link style={styles} href="/prepare">
              Prepare
            </Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link style={styles} href="/arrivals">
              Arrivals
            </Nav.Link>
          </Nav.Item>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  ) : (
    <NoLogin></NoLogin>
  );
};
export const Jumbotr = props => (
  <Jumbotron fluid className="Jumbotron">
    <div className="overlay"> </div>
    {props.value === "arrivals" ? (
      <div>
        <h1>Guest List Arrivals</h1>
        <p>List of guests to check-in today</p>
      </div>
    ) : (
      <div>
        <h1>Guest List Prepare</h1>
        <p>List of guests to check-in in future</p>
      </div>
    )}
  </Jumbotron>
);

export default App;
