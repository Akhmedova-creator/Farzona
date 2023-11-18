var swiper = new Swiper(".mySwiper", {
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
    },
    // slidesPerView: 7,
    // centeredSlides: false,
    // spaceBetween: 5,
    // grabCursor: true,
    // // loop: true,
    // watchOverflow: true,

 // Default parameters
//  slidesPerView: 7,
//  spaceBetween: 5,
 // Responsive breakpoints
 breakpoints: {
   // when window width is >= 320px
   320: {
     slidesPerView: 2,
     spaceBetween: 20
   },
   // when window width is >= 480px
   480: {
     slidesPerView: 3,
     spaceBetween: 30
   },
   // when window width is >= 640px
   640: {
     slidesPerView: 4,
     spaceBetween: 40
   },
   820: {
    slidesPerView: 5,
    spaceBetween: 10
  },
   1200: {
    slidesPerView: 6,
    spaceBetween: 10
  },
   1500: {
    slidesPerView: 7,
    spaceBetween: 5
  }
 }




    
    // pagination: {
    //   el: ".swiper-pagination",
    //   clickable: true,
    // },
  });