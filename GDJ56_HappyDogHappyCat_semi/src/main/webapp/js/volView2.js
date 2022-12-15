   var slide = 1;
    $('.slide-1').on('click', function(){
        $('.slide-container').css('transform', 'translateX(0vw)');
        slide = 1;
    })

    $('.slide-2').on('click', function(){
        $('.slide-container').css('transform', 'translateX(-100vw)');
        slide = 2;
    })

    $('.slide-3').on('click', function(){
        $('.slide-container').css('transform', 'translateX(-200vw)');
        slide = 3;
    })

    $('.prev').on('click', function(){
        if (slide == 3){
            $('.slide-container').css('transform', 'translateX(-100vw)');
            slide = 2;
        } else if (slide == 2){
            $('.slide-container').css('transform', 'translateX(-0vw)');
            slide = 1;
        }
    })

    $('.next').on('click', function(){
        if (slide == 1){
            $('.slide-container').css('transform', 'translateX(-100vw)');
            slide = 2;
        } else if (slide == 2){
            $('.slide-container').css('transform', 'translateX(-200vw)');
            slide = 3;
        }
    })

    $('.slider-2 .page-nav > div').click(function() {
    
    var $this = $(this);
    var $pagenav = $this.parent()
    var $current = $pagenav.find('.active');
    
    $current.removeClass('active');
    $this.addClass('active');

    var index = $this.index();
    var $슬라이더 = $this.closest('.slider-2');
    
    $슬라이더.find('.slides > div.active').removeClass('active');
    $슬라이더.find('.slides > div').eq(index).addClass('active');
    
    
    });

    $('.slider-2 > .side-btns > div:first-child').click(function() {
        var $this = $(this);
        var $slider = $this.closest('.slider-2');
        
        var $current = $slider.find('.page-nav > div.active');
        var $post = $current.prev();
        
        if ( $post.length == 0 ) {
            $post = $slider.find('.page-nav > div:last-child');
        }
        
        $post.click();
    });

    $('.slider-2 > .side-btns > div:last-child').click(function() {
        var $this = $(this);
        var $slider = $this.closest('.slider-2');
        
        var $current = $slider.find('.page-nav > div.active');
        var $post = $current.next();
        
        if ( $post.length == 0 ) {
            $post = $slider.find('.page-nav > div:first-child');
        }
        
        $post.click();
    });
