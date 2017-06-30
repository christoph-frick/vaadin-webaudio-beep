// paritally lifted from https://stackoverflow.com/questions/879152/how-do-i-make-javascript-beep/29641185#29641185
window.app_ui_Beeper = function() {

    var audioCtx = new (window.AudioContext || window.webkitAudioContext || window.audioContext);

    this.beep = function(duration, frequency) {
        var oscillator = audioCtx.createOscillator();
        var gainNode = audioCtx.createGain();

        oscillator.connect(gainNode);
        gainNode.connect(audioCtx.destination);

        if (frequency){oscillator.frequency.value = frequency;}

        oscillator.start();
        setTimeout(function(){oscillator.stop()}, (duration ? duration : 500));
    };

};
