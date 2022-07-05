import classes from "./Navbar.module.css";
import { Link } from "react-router-dom";

function Navbar() {
  const logo = require("../../assets/RAUH-WELT-black.png");
  return (
    <header className={classes.navbar}>
      <div className={classes.leftNav}>
        <Link to="/about">About</Link>
        <Link to="/store">Store</Link>
      </div>
      <div>
      <Link to="/"> <img className={classes.logo} src={logo} alt="logo" /> </Link>
      </div>
      <div className={classes.rightNav}>
        <Link to="/product">Product</Link>
        <Link to="/contact">Contact</Link>
      </div>
    </header>
  );
}
export default Navbar;
