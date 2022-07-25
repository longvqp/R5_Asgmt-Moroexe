import React from "react";
import { Navbar, Container, NavDropdown, Nav } from "react-bootstrap";
import styles from "./header.module.css";
import logo from "../../assets/Img/muroexe.png";
function Header(params) {
  return (
    <Navbar fluid style={{ margin: 0, padding: 10 }} expand="lg">
      <Container fluid className={styles.header}>
        <Navbar.Brand href="#home">
          <img src={logo} />
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className={styles.navLink}>
            <Nav.Link href="#home">Sandal</Nav.Link>
            <Nav.Link href="#link">Sneaker</Nav.Link>
            <Nav.Link href="#link">Sliper</Nav.Link>
            <Nav.Link href="#link">Boot</Nav.Link>
            <Nav.Link href="#link">Accessory</Nav.Link>

            <NavDropdown title="Account" id="basic-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">
                Another action
              </NavDropdown.Item>
              <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.4">
                Separated link
              </NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Header;
