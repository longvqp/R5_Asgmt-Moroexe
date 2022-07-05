import Item from '../ui/Item';
import classes from './Tune.module.css';

function Tune(){
    return (
        <div >
            <header className={classes.header}>
                <h2>OUR TUNE</h2>
            </header>
            <div className={classes.container}>
                <div className={classes.timeLine}></div>
                <Item></Item>
            </div>
        </div>
    );
}

export default Tune