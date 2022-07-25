import React from "react";
import { Container, Row, Col } from "react-bootstrap";
import Carousel from "react-bootstrap/Carousel";
import styles from "./banner.module.css";
import banner1 from "../../assets/Img/banner1.png";
import banner2 from "../../assets/Img/banner2.png";
import side1 from "../../assets/Img/side1.jpg";
import side2 from "../../assets/Img/side2.jpg";
import side3 from "../../assets/Img/side3.jpg";
import side4 from "../../assets/Img/side4.jpg";
function Banner(params) {
  return (
    <Container fluid>
      <Row style={{ marginTop: 10 }}>
        <Col xs={8}>
          <div className={styles.mainBanner}>
            <Carousel className={styles.carousel}>
              <Carousel.Item>
                <img src={banner1} alt="First slide" />
                <Carousel.Caption>
                  <h3>First slide label</h3>
                  <p>
                    Nulla vitae elit libero, a pharetra augue mollis interdum.
                  </p>
                </Carousel.Caption>
              </Carousel.Item>
              <Carousel.Item>
                <img src={banner2} alt="Second slide" />
                <Carousel.Caption>
                  <h3>Second slide label</h3>
                  <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  </p>
                </Carousel.Caption>
              </Carousel.Item>
            </Carousel>
          </div>
        </Col>

        <Col xs={4}>
          <div className={styles.sideBanner}>
          <Carousel className={styles.sideCarousel}>
              <Carousel.Item>
                <img src={side1} alt="First slide" />
              </Carousel.Item>
              <Carousel.Item>
                <img src={side2} alt="Second slide" />
              </Carousel.Item>
              <Carousel.Item>
                <img src={side3} alt="Second slide" />
              </Carousel.Item>
              <Carousel.Item>
                <img src={side4} alt="Second slide" />
              </Carousel.Item>
            </Carousel>
          </div>
        </Col>
      </Row>
    </Container>
  );
}

export default Banner;
