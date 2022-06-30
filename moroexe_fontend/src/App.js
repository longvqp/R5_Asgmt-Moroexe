import Layout from "./components/layout/Layout";
import Landing from "./pages/Landing";
import About from "./pages/About"
import Contact from './pages/Contact';
import Product from './pages/Product';
import Store from './pages/Store';
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <Layout>
      <Routes>
        <Route index path="/" element={<Landing/>} />
        <Route path="/about" element={<About/>} />
        <Route path="/store" element={<Store/>} />
        <Route path="/product" element={<Product/>} />
        <Route path="/contact" element={<Contact/>} />
        
      </Routes>
      
    </Layout>
  );
}
export default App;
