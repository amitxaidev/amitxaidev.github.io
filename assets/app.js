/* Compiled Canvas – progress tracking, filters, reveals and a bit of motion */
(function () {
  document.documentElement.classList.add('js');
  var KEY = 'cc-dsa-done';
  var reduceMotion = window.matchMedia('(prefers-reduced-motion: reduce)').matches;

  function load() {
    try { return new Set(JSON.parse(localStorage.getItem(KEY) || '[]')); } catch (_) { return new Set(); }
  }
  function save(set) {
    try { localStorage.setItem(KEY, JSON.stringify(Array.from(set))); } catch (_) {}
  }
  var done = load();

  // ---------- theme (light by default, remembers the choice)
  var html = document.documentElement;
  var themeBtn = document.querySelector('.theme-btn');
  function syncTheme() {
    var dark = html.getAttribute('data-bs-theme') === 'dark';
    if (themeBtn) themeBtn.textContent = dark ? 'Light mode' : 'Dark mode';
    var l = document.getElementById('hl-light'), d = document.getElementById('hl-dark');
    if (l && d) { l.disabled = dark; d.disabled = !dark; }
  }
  if (themeBtn) themeBtn.addEventListener('click', function () {
    var next = html.getAttribute('data-bs-theme') === 'dark' ? 'light' : 'dark';
    html.setAttribute('data-bs-theme', next);
    try { localStorage.setItem('cc-theme', next); } catch (_) {}
    syncTheme();
  });
  syncTheme();

  // ---------- progress
  function refresh() {
    document.querySelectorAll('.done-box').forEach(function (box) {
      box.checked = done.has(box.dataset.slug);
      var row = box.closest('tr');
      if (row) row.classList.toggle('is-done', box.checked);
    });
    document.querySelectorAll('[data-slugs]').forEach(function (el) {
      var slugs = el.dataset.slugs.split(',');
      var n = slugs.filter(function (s) { return done.has(s); }).length;
      var c = el.querySelector('.done-count'); if (c) c.textContent = n;
      var bar = el.querySelector('.progress-bar'); if (bar) bar.style.width = (100 * n / slugs.length) + '%';
      var ring = el.querySelector('.ring-sm');
      if (ring) { var pct = Math.round(100 * n / slugs.length); ring.style.setProperty('--p', pct); ring.querySelector('.done-pct').textContent = pct + '%'; }
    });
    var data = document.getElementById('all-problems');
    var cont = document.querySelector('.continue-btn');
    if (data && cont && done.size) {
      var list = JSON.parse(data.textContent);
      var next = list.find(function (p) { return !done.has(p.slug); });
      if (next) { cont.href = next.url; cont.textContent = 'Continue: ' + next.title; }
      else { cont.href = '#topics'; cont.textContent = 'All solved – well done!'; }
    }
    applyFilter();
  }
  document.addEventListener('change', function (ev) {
    var box = ev.target;
    if (!box.classList || !box.classList.contains('done-box')) return;
    if (box.checked) { done.add(box.dataset.slug); confetti(box); } else done.delete(box.dataset.slug);
    save(done);
    refresh();
  });
  var reset = document.querySelector('.reset');
  if (reset) reset.addEventListener('click', function () {
    if (!confirm('Clear your saved progress in this browser?')) return;
    done = new Set(); save(done); refresh();
  });
  window.addEventListener('storage', function (ev) { if (ev.key === KEY) { done = load(); refresh(); } });

  // ---------- filter + search on topic pages
  var filter = 'all';
  var search = document.querySelector('.search');
  function applyFilter() {
    var rows = document.querySelectorAll('.ptable tbody tr');
    if (!rows.length) return;
    var q = search ? search.value.trim().toLowerCase() : '';
    var shown = 0;
    rows.forEach(function (row) {
      var isDone = done.has(row.dataset.slug);
      var ok = filter === 'all' || row.dataset.diff === filter ||
        (filter === 'done' && isDone) || (filter === 'todo' && !isDone);
      if (ok && q) ok = row.dataset.text.indexOf(q) !== -1;
      row.hidden = !ok;
      if (ok) shown++;
    });
    var empty = document.querySelector('.empty');
    if (empty) empty.hidden = shown !== 0;
  }
  document.querySelectorAll('[data-filter]').forEach(function (btn) {
    btn.addEventListener('click', function () {
      document.querySelectorAll('[data-filter]').forEach(function (b) { b.classList.remove('active'); });
      btn.classList.add('active');
      filter = btn.dataset.filter;
      applyFilter();
    });
  });
  if (search) search.addEventListener('input', applyFilter);

  // ---------- show/hide hints, approach and solution (hints unlock one by one)
  document.querySelectorAll('.reveal').forEach(function (btn) {
    btn.addEventListener('click', function () {
      var body = btn.nextElementSibling;
      var opening = body.hidden;
      body.hidden = !opening;
      btn.textContent = opening ? btn.dataset.label.replace('Show', 'Hide') : btn.dataset.label;
      btn.classList.toggle('active', opening);
      var hint = btn.closest('.hint');
      if (opening) markStep(hint ? 'hints' : (body.classList.contains('code-block') ? 'solution' : 'approach'));
      var next = hint && hint.nextElementSibling;
      if (opening && next && next.classList.contains('hint')) next.hidden = false;
      var code = body.querySelector('code');
      if (opening && code && window.hljs && !code.classList.contains('hljs')) window.hljs.highlightElement(code);
    });
  });

  // ---------- copy code
  document.querySelectorAll('.copy').forEach(function (btn) {
    btn.addEventListener('click', function () {
      var code = btn.parentElement.querySelector('code').innerText;
      if (!navigator.clipboard) return;
      navigator.clipboard.writeText(code).then(function () {
        btn.textContent = 'Copied';
        setTimeout(function () { btn.textContent = 'Copy'; }, 1500);
      });
    });
  });

  // ---------- confetti when a problem is marked solved
  function confetti(from) {
    if (reduceMotion) return;
    var r = from.getBoundingClientRect(), colors = ['#e8590c', '#ffc629', '#ff8a1f', '#198754', '#0d6efd'];
    for (var i = 0; i < 26; i++) {
      var c = document.createElement('span');
      c.className = 'confetti';
      c.style.left = (r.left + r.width / 2) + 'px';
      c.style.top = (r.top + r.height / 2) + 'px';
      c.style.background = colors[i % colors.length];
      c.style.setProperty('--x', (Math.random() * 240 - 120) + 'px');
      c.style.setProperty('--y', (Math.random() * -180 - 20) + 'px');
      c.style.setProperty('--r', (Math.random() * 720 - 360) + 'deg');
      document.body.appendChild(c);
      setTimeout(function (el) { el.remove(); }, 1200, c);
    }
  }

  // ---------- step tracker on problem pages
  function markStep(name) {
    var li = document.querySelector('.journey [data-step="' + name + '"]');
    if (li) li.classList.add('done');
  }
  if (document.querySelector('.journey')) {
    markStep('read');
    var solvedBox = document.querySelector('.problem .done-box, #done');
    if (solvedBox && solvedBox.checked) markStep('solved');
    document.addEventListener('change', function (ev) {
      if (ev.target.id === 'done') {
        var li = document.querySelector('.journey [data-step="solved"]');
        if (li) li.classList.toggle('done', ev.target.checked);
      }
    });
  }

  // ---------- 3D tilt (cards, bobblehead)
  if (!reduceMotion && window.matchMedia('(hover: hover)').matches) {
    document.querySelectorAll('[data-tilt]').forEach(function (el) {
      var target = el.classList.contains('toon') ? el.querySelector('.toon-stage') : el;
      el.addEventListener('pointermove', function (ev) {
        var b = el.getBoundingClientRect();
        var x = (ev.clientX - b.left) / b.width - 0.5, y = (ev.clientY - b.top) / b.height - 0.5;
        var k = el.classList.contains('toon') ? 22 : 8;
        target.style.transform = 'perspective(800px) rotateY(' + (x * k) + 'deg) rotateX(' + (-y * k) + 'deg) translateZ(0)';
      });
      el.addEventListener('pointerleave', function () { target.style.transform = ''; });
    });
  }

  // ---------- ← → between problems
  document.addEventListener('keydown', function (ev) {
    if (ev.altKey || ev.ctrlKey || ev.metaKey) return;
    var tag = (ev.target.tagName || '').toLowerCase();
    if (tag === 'input' || tag === 'textarea') return;
    var link = document.querySelector('.pager a[data-key="' + ev.key + '"]');
    if (link) location.href = link.href;
  });

  // ---------- scroll motion: fade things in, count numbers up
  function countUp(el) {
    var target = +el.dataset.count, start = null;
    if (reduceMotion || !target) return;
    function step(t) {
      if (!start) start = t;
      var p = Math.min(1, (t - start) / 900);
      el.textContent = Math.round(target * (1 - Math.pow(1 - p, 3)));
      if (p < 1) requestAnimationFrame(step);
    }
    el.textContent = '0';
    requestAnimationFrame(step);
  }
  var animated = document.querySelectorAll('.fade-up, .stagger, .path, .trace, .diff-chart, .diff-bar, [data-step-watch], [data-count]');
  if ('IntersectionObserver' in window && !reduceMotion) {
    var io = new IntersectionObserver(function (entries) {
      entries.forEach(function (en) {
        if (!en.isIntersecting) return;
        var el = en.target;
        if (el.classList.contains('stagger')) {
          el.querySelectorAll('tbody tr').forEach(function (tr, i) { tr.style.transitionDelay = Math.min(i, 20) * 25 + 'ms'; });
        }
        el.classList.add('in');
        if (el.dataset.stepWatch) markStep(el.dataset.stepWatch);
        if (el.dataset.count) countUp(el);
        io.unobserve(el);
      });
    }, { threshold: 0.12 });
    animated.forEach(function (el) { io.observe(el); });
  } else {
    animated.forEach(function (el) { el.classList.add('in'); if (el.dataset.stepWatch) markStep(el.dataset.stepWatch); });
  }

  // ---------- hero: typed code + animated two-pointer bars
  var typed = document.getElementById('typed');
  if (typed) {
    var text = typed.dataset.text;
    var keywords = /\b(int|while|if|else|return|true|for|String)\b/g;
    function paint(s) {
      return s.replace(/&/g, '&amp;').replace(/</g, '&lt;')
        .replace(keywords, '<span class="kw">$1</span>').replace(/\b(\d+)\b/g, '<span class="num">$1</span>');
    }
    if (reduceMotion) typed.innerHTML = paint(text);
    else {
      var i = 0;
      (function type() {
        i++;
        typed.innerHTML = paint(text.slice(0, i));
        if (i < text.length) setTimeout(type, text[i - 1] === '\n' ? 220 : 32);
        else setTimeout(function () { i = 0; type(); }, 4000);
      })();
    }
  }

  var canvas = document.getElementById('hero-canvas');
  if (canvas && canvas.getContext) {
    var ctx = canvas.getContext('2d');
    var bars = [], n = 18, l = 0, r = n - 1, phase = 0, last = 0;
    function reset() {
      bars = [];
      for (var k = 0; k < n; k++) bars.push(2 + Math.round(Math.random() * 10));
      bars.sort(function (a, b) { return a - b; });
      l = 0; r = n - 1;
    }
    function size() {
      var dpr = window.devicePixelRatio || 1;
      canvas.width = canvas.clientWidth * dpr;
      canvas.height = canvas.clientHeight * dpr;
      ctx.setTransform(dpr, 0, 0, dpr, 0, 0);
    }
    function draw() {
      var w = canvas.clientWidth, h = canvas.clientHeight;
      ctx.clearRect(0, 0, w, h);
      var narrow = w < 768;
      var area = narrow ? w - 32 : Math.min(w * 0.55, 620), x0 = w - area - (narrow ? 16 : 24), gap = narrow ? 4 : 6;
      var bw = (area - gap * (n - 1)) / n, unit = Math.min(h * 0.7, 300) / 12;
      for (var k = 0; k < n; k++) {
        var bh = bars[k] * unit, x = x0 + k * (bw + gap), y = h - 20 - bh;
        ctx.fillStyle = (k === l || k === r) ? '#e8590c' : (k < l || k > r) ? '#3a3026' : '#3b3b3b';
        ctx.fillRect(x, y, bw, bh);
        if (k === l || k === r) {
          ctx.fillStyle = '#f6b93b';
          ctx.font = '600 12px ui-monospace, Menlo, monospace';
          ctx.fillText(k === l ? 'l' : 'r', x + bw / 2 - 3, h - 4);
        }
      }
    }
    function tick(t) {
      if (t - last > 650) {
        last = t;
        if (l >= r) { if (++phase > 2) { phase = 0; reset(); } }
        else if ((bars[l] + bars[r]) % 2) l++; else r--;   // move one pointer each step
      }
      draw();
      requestAnimationFrame(tick);
    }
    reset();
    size();
    window.addEventListener('resize', function () { size(); draw(); });
    if (reduceMotion) draw(); else requestAnimationFrame(tick);
  }

  refresh();
})();
