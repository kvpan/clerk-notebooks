(ns moira
  {:nextjournal.clerk/visibility {:code :hide :result :show}}
  (:require [nextjournal.clerk :as clerk]))

;; # Official WHO data on newborn growth
;; Source: https://www.who.int/tools/child-growth-standards/standards/

;; ## Weight
(let [expected {:Week [0 1 2 3 4 5 6 7 8 9 10 11 12 13],
                :S [0.14171 0.146 0.14339 0.1406 0.13805 0.13583 0.13392 0.13228 0.13087 0.12966 0.12861 0.1277 0.12691 0.12622],
                :SD3neg [2 2.1 2.3 2.5 2.7 2.9 3 3.2 3.3 3.5 3.6 3.8 3.9 4],
                :SD2neg [2.4 2.5 2.7 2.9 3.1 3.3 3.5 3.7 3.8 4 4.1 4.3 4.4 4.5],
                :SD1neg [2.8 2.9 3.1 3.3 3.6 3.8 4 4.2 4.4 4.6 4.7 4.9 5 5.1],
                :SD0 [3.2 3.3 3.6 3.8 4.1 4.3 4.6 4.8 5 5.2 5.4 5.5 5.7 5.8],
                :SD1 [3.7 3.9 4.1 4.4 4.7 5 5.2 5.5 5.7 5.9 6.1 6.3 6.5 6.6],
                :SD2 [4.2 4.4 4.7 5 5.4 5.7 6 6.2 6.5 6.7 6.9 7.1 7.3 7.5],
                :SD3 [4.8 5.1 5.4 5.7 6.1 6.5 6.8 7.1 7.3 7.6 7.8 8.1 8.3 8.5]}
      week (:Week expected)
      moira [2.640 nil  2.690 2.770 2.960 3.120 3.250 3.320 3.770]]
  (clerk/plotly {:data [{:x week :y (:SD0 expected) :type "scatter" :mode "lines" :name "Median"}
                        {:x week :y (:SD1neg expected) :type "scatter" :mode "lines" :name "SD -1"}
                        {:x week :y (:SD2neg expected) :type "scatter" :mode "lines" :name "SD -2"}
                        {:x week :y (:SD3neg expected) :type "scatter" :mode "lines" :name "SD -3"}
                        {:x week :y moira :type "scatter" :mode "markers" :name "Moira" :marker {:size 7 :color "#666"}}]
                 :layout {:title "Z-score for weight-for-age"
                          :xaxis {:title "Weeks"}
                          :yaxis {:title "Weight (kg)"}}}))

(let [expected {:Week [0 1 2 3 4 5 6 7 8 9 10 11 12 13],
                :S [0.14171 0.146 0.14339 0.1406 0.13805 0.13583 0.13392 0.13228 0.13087 0.12966 0.12861 0.1277 0.12691 0.12622],
                :P01 [2 2.1 2.2 2.4 2.6 2.8 3 3.2 3.3 3.4 3.6 3.7 3.8 3.9],
                :P1 [2.3 2.3 2.5 2.7 2.9 3.1 3.3 3.5 3.7 3.8 4 4.1 4.2 4.3],
                :P3 [2.4 2.5 2.7 2.9 3.1 3.3 3.5 3.7 3.9 4.1 4.2 4.3 4.5 4.6],
                :P5 [2.5 2.6 2.8 3 3.3 3.5 3.7 3.8 4 4.2 4.3 4.5 4.6 4.7],
                :P10 [2.7 2.8 3 3.2 3.4 3.6 3.8 4 4.2 4.4 4.5 4.7 4.8 5],
                :P15 [2.8 2.9 3.1 3.3 3.5 3.8 4 4.2 4.4 4.5 4.7 4.8 5 5.1],
                :P25 [2.9 3 3.2 3.5 3.7 4 4.2 4.4 4.6 4.7 4.9 5.1 5.2 5.4],
                :P50 [3.2 3.3 3.6 3.8 4.1 4.3 4.6 4.8 5 5.2 5.4 5.5 5.7 5.8],
                :P75 [3.6 3.7 3.9 4.2 4.5 4.8 5 5.2 5.5 5.7 5.8 6 6.2 6.4],
                :P85 [3.7 3.9 4.1 4.4 4.7 5 5.3 5.5 5.7 5.9 6.1 6.3 6.5 6.7],
                :P90 [3.9 4 4.3 4.6 4.9 5.2 5.4 5.7 5.9 6.1 6.3 6.5 6.7 6.9],
                :P95 [4 4.2 4.5 4.8 5.1 5.4 5.7 5.9 6.2 6.4 6.6 6.8 7 7.2],
                :P97 [4.2 4.4 4.6 5 5.3 5.6 6 6.2 6.5 6.6 6.8 7 7.2 7.4],
                :P99 [4.4 4.6 4.9 5.3 5.6 5.9 6.2 6.5 6.7 7 7.2 7.4 7.6 7.8],
                :P999 [4.8 5.1 5.4 5.7 6.2 6.5 6.8 7.1 7.3 7.6 7.8 8.1 8.3 8.6]}
      week (:Week expected)
      moira [2.640 nil 2.690 2.770 2.960 3.120 3.250 3.320 3.770]]
  (clerk/plotly {:data [{:x week :y (:P50 expected) :type "scatter" :mode "lines" :name "50"}
                        {:x week :y (:P10 expected) :type "scatter" :mode "lines" :name "10"}
                        {:x week :y (:P5 expected) :type "scatter" :mode "lines" :name "5"}
                        {:x week :y (:P3 expected) :type "scatter" :mode "lines" :name "3"}
                        {:x week :y (:P1 expected) :type "scatter" :mode "lines" :name "1"}
                        {:x week :y (:P01 expected) :type "scatter" :mode "lines" :name "0.1"}
                        {:x week :y moira :type "scatter" :mode "markers" :name "Moira" :marker {:size 7 :color "#666"}}]
                 :layout {:title "Percentile for weight-for-age"
                          :xaxis {:title "Weeks"}
                          :yaxis {:title "Weight (kg)"}}}))
;; ## Height
(let [expected {:Week [0 1 2 3 4 5 6 7 8 9 10 11 12 13],
                :S [0.0379 0.03742 0.03694 0.03669 0.03647 0.03627 0.03609 0.03593 0.03578 0.03564 0.03552 0.0354 0.0353 0.0352],
                :SD3neg [43.6 44.7 45.8 46.7 47.5 48.3 49.1 49.8 50.5 51.2 51.8 52.4 52.9 53.5],
                :SD2neg [45.4 46.6 47.7 48.6 49.5 50.3 51.1 51.8 52.5 53.2 53.8 54.4 55 55.6],
                :SD1neg [47.3 48.4 49.6 50.5 51.4 52.3 53.1 53.8 54.6 55.2 55.9 56.5 57.1 57.7],
                :SD0 [49.1 50.3 51.5 52.5 53.4 54.2 55.1 55.8 56.6 57.3 57.9 58.6 59.2 59.8],
                :SD1 [51 52.2 53.4 54.4 55.3 56.2 57.1 57.8 58.6 59.3 60 60.7 61.3 61.9],
                :SD2 [52.9 54.1 55.3 56.3 57.3 58.2 59 59.9 60.6 61.4 62.1 62.7 63.4 64],
                :SD3 [54.7 56 57.2 58.2 59.2 60.1 61 61.9 62.6 63.4 64.1 64.8 65.5 66.1]}
      week (:Week expected)
      moira [48 48.5 50 51.5 nil nil nil 52.5]]
  (clerk/plotly {:data [{:x week :y (:SD0 expected) :type "scatter" :mode "lines" :name "Median"}
                        {:x week :y (:SD1neg expected) :type "scatter" :mode "lines" :name "SD -1"}
                        {:x week :y (:SD2neg expected) :type "scatter" :mode "lines" :name "SD -2"}
                        {:x week :y moira :type "scatter" :mode "markers" :name "Moira" :marker {:size 7 :color "#666"}}]
                 :layout {:title "Z-score for height-for-age"
                          :xaxis {:title "Weeks"}
                          :yaxis {:title "Height (cm)"}}}))

;; ## Head circumference
(let [expected {:Week [0 1 2 3 4 5 6 7 8 9 10 11 12 13],
                :S [0.03496 0.03374 0.03251 0.03231 0.03215 0.03202 0.03191 0.03182 0.03173 0.03166 0.03158 0.03152 0.03146 0.0314],
                :SD3neg [30.3 31.1 31.8 32.4 32.9 33.3 33.7 34.1 34.4 34.7 35 35.3 35.5 35.8],
                :SD2neg [31.5 32.2 32.9 33.5 34 34.5 34.9 35.3 35.6 35.9 36.2 36.5 36.8 37],
                :SD1neg [32.7 33.4 34.1 34.7 35.2 35.7 36.1 36.5 36.8 37.1 37.4 37.7 38 38.3],
                :SD0 [33.9 34.6 35.2 35.8 36.4 36.8 37.3 37.7 38 38.4 38.7 39 39.3 39.5],
                :SD1 [35.1 35.7 36.4 37 37.5 38 38.5 38.9 39.2 39.6 39.9 40.2 40.5 40.8],
                :SD2 [36.2 36.9 37.5 38.2 38.7 39.2 39.6 40.1 40.4 40.8 41.1 41.4 41.7 42],
                :SD3 [37.4 38.1 38.7 39.3 39.9 40.4 40.8 41.3 41.6 42 42.3 42.7 43 43.2]}
      week (:Week expected)
      moira [nil 34 35 35 nil nil 36 38]]
  (clerk/plotly {:data [{:x week :y (:SD0 expected) :type "scatter" :mode "lines" :name "Median"}
                        {:x week :y (:SD1neg expected) :type "scatter" :mode "lines" :name "SD -1"}
                        {:x week :y (:SD2neg expected) :type "scatter" :mode "lines" :name "SD -2"}
                        {:x week :y moira :type "scatter" :mode "markers" :name "Moira" :marker {:size 7 :color "#666"}}]
                 :layout {:title "Z-score for height-for-age"
                          :xaxis {:title "Weeks"}
                          :yaxis {:title "Height (cm)"}}}))

