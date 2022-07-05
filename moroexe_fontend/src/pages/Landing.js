import Tune from "../components/tune/Tune";
import classes from "./Landing.module.css";

function Landing() {
  //const vide = require("../assets/video.mp4");
  return (
    <div>
      <div className={classes.backdrop}>
        <div className={classes.textContainer}>
          <h1 className={classes.heading}>
            Change your life with<b> RWB </b>{" "}
          </h1>
          <h2 className={classes.subheading}>
            RWB / RAUH-Welt BEGRIFF is a Porsche tuner located in Japan.
          </h2>
          <h2 className={classes.subheading}>
            <b>
              <u>@RWBJP</u>
            </b>
          </h2>
          <button className="transition ease-in-out hover:-translate-y-1 hover:scale-110 hover:bg-indigo-500 duration-300 rounded-full hover:box-border hover:text-white bg-white p-2 hover:border-4 mt-10 hover:border-violet-400">Read More</button>
        </div>
      </div>
      <div className={classes.vidContainer}>
        <video autoPlay loop muted class={classes.vid}>
          {/* <source src={vide} type="video/mp4" /> */}
        </video>
      </div>

      <div className={classes.content}>
          <div className={classes.main}>
                <Tune></Tune>
        </div>
      </div>
    </div>
  );
}
export default Landing;
