import React from "react";
import { Container, Row } from "react-bootstrap";
import ProductCard from "../card/card";
import styles from "./product.module.css";
function ProductListing(params) {
  return (
    <Container fluid>
      <Row className={styles.productPannel}>
        <h1>This is product</h1>

        <ProductCard/>
        
        

      </Row>
    </Container>
  );
}

export default ProductListing;
