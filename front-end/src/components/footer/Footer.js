import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import './footer.css';

export default function Footer(){
    return (
        <footer className="footer"  data-aos="slide-up">
            <div className="container bottom_border">
                <div className="row">
                    <div className=" col-sm-4 col-md col-sm-4  col-12 col">
                        <h5 className="color_white pt2">Find us</h5>
                        <p className="mb10">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>
                        <p><i className="fa fa-location-arrow"></i> Panepisthmiou 36 </p>
                        <p><i className="fa fa-phone"></i>  +30-2109999999  </p>
                        <p><i className="fa fa fa-envelope"></i> Alt+Habit@info.com  </p>
                     </div>
        
                     <div className=" col-sm-4 col-md  col-6 col">
                        <h5 className="color_white pt2">Quick links</h5>
        
                        <ul className="footer_ul">
                            <li><a href="Sports Descrciption">Sports Descrciption</a></li>
                            <li><a href="Health & Sports">Health & Sports</a></li>
                            <li><a href="Nutrition">Nutrition</a></li>
                            <li><a href="Ebay & Amazon">Ebay & Amazon</a></li>
                        </ul>
                    </div>

                    <div className=" col-sm-4 col-md  col-6 col">
                        <h5 className="color_white pt2">Quick links</h5>
       
                        <ul className="footer_ul">
                            <li><a href="History of Sports">History of Sports</a></li>
                            <li><a href="Whatever">Whatever </a></li>
                            <li><a href="#">Whatever</a></li>
                            <li><a href="#">Whatever</a></li>
                            <li><a href="#">Whatever</a></li>
                        </ul>
                    </div>

                    <div className=" col-sm-4 col-md  col-12 col">
                        <h5 className="color_white pt2">Follow us</h5>
            
                        <ul className="footer_ul2">
                            <li><a href="#"><i className="fa fa-twitter flt padding-right"></i> </a><p>Lorem Ipsum is simply dummy text of the printing...<a href="#">https://www.lipsum.com/</a></p></li>
                            <li><a href="#"><i className="fa fa-twitter flt padding-right"></i> </a><p>Lorem Ipsum is simply dummy text of the printing...<a href="#">https://www.lipsum.com/</a></p></li>
                            <li><a href="#"><i className="fa fa-twitter flt padding-right"></i> </a><p>Lorem Ipsum is simply dummy text of the printing...<a href="#">https://www.lipsum.com/</a></p></li>
                        </ul>
                    </div>
                </div>
            </div>
        
            <div className="container">
            
                <p className="text-center">Copyright @2017 | Designed by <a href="#">ALTERHABITS</a></p>
            
                <ul className="social_footer_ul">
                    <li>  <a href="https://www.facebook.com"><i  className="fa fa-facebook-square fa-3x social"></i></a></li>
                    <li>   <a href="https://twitter.com"><i id="social-tw" className="fa fa-twitter-square fa-3x social"></i></a></li>
                    <li>  <a href="https://google.com"><i id="social-gp" className="fa fa-google-plus-square fa-3x social"></i></a></li>
                    <li><a href="https://gmail.com"><i id="social-em" className="fa fa-envelope-square fa-3x social"></i></a></li>
                </ul>
            </div>
        
        </footer>
        
       
        )
    }
    
