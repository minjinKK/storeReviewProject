/**
   * ProgressBar
   */
var progress = $('.progress2');

progress.each(function () {

	var _self = $(this);
	var progressNumber = _self.find('.progress2__number');
	progressNumber.text('0');

	_self.waypoint(function (direction) {
		var progressBar = _self.find('.progress2__bar'),
			    delay = progressBar.data("delay"),
			    durations = progressBar.data("duration"),
			    timing = progressBar.data("timing"),
			    getPercent = progressBar.data('progress-percent');
		
		console.log( getPercent+'점');

		progressBar.css({
			'width': (getPercent*20) + '%',
			'transition': 'all ' + durations + 'ms ' + timing,
			'transition-delay': delay + 'ms'
		});

		setTimeout(function () {
			progressNumber.prop('Counter', 0).animate({
				Counter: getPercent
			}, {
				duration: durations,
				easing: 'swing',
				step: function step(now) {
					$(this).text(now.toFixed(1) + '점');
				}
			});
		}, delay);

		this.destroy();
	}, {
		offset: function offset() {
			return Waypoint.viewportHeight() - _self.outerHeight() - 150;
		}
	});
});