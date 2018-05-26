(ns rf-mater.views
  (:require [cljsjs.material-ui]
            [re-frame.core :as re-frame]
            [rf-mater.subs :as subs]
            [cljs-react-material-ui.core :refer [get-mui-theme color]]
            [cljs-react-material-ui.reagent :as ui]
            [cljs-react-material-ui.icons :as ic]
            [reagent.core :as r]
            [garden.core :refer [css]]
            ))

;; home
; Example with various components
(defn app-bar []
  (let []
    [ui/app-bar {:title "Razem Na Stok"
                 :showMenuIconButton false
                 :titleStyle {:color (color :lime200)
                              :textAlign :center
                  }}]))

(defn jumbotron []
  (let []
    [ui/paper {:style {:height "200px"
                       :width "auto"
                       ;:max-width "40%"
                       :margin "10px 0px"
                       :textAlign "center"
                       :display "flex"
                      }
               :zDepth "1"}]))

(defn destination-card []
  (let []
    (fn []
      [ui/card {:style {:margin "10px 0px"}}

         [:div.destination {:style {:padding "5px"
                        :display "flex"
                        :justify-content "space-between"
                       :align-items "center"}}

          [ui/card-title {:title "Jańskie Łaźnie"
                          :subtitle "miejsce docelowe"
                          :style {:padding "5px"}}]

          [ui/raised-button {:label "negocjacja"
                              :primary true
                              :disable false}]]

        [:div.day {:style {:padding "5px"
                       :display "flex"
                       :justify-content "space-between"
                       :align-items "center"}}

          [ui/card-title {:title "sobota, 14-04-18"
                          :subtitle "dzień wyjazdu"
                          :style {:padding "5px"
                                   :font-size "20px"}}]

          [ui/raised-button {:label "negocjacja"
                             :primary true
                             :disable false}]]
        [ui/divider]
        [ui/card-text
          [ui/table
            [ui/table-body {:display-row-checkbox false}
              [ui/table-row
                [ui/table-row-column "odległosc"]
                 [ui/table-row-column "150km"]
              ]
              [ui/table-row
                [ui/table-row-column "w drodze"]
                 [ui/table-row-column "2,5h"]
              ]
              [ui/table-row
                [ui/table-row-column "wyjazd"]
                 [ui/table-row-column "7:00"]
              ]
              [ui/table-row
                [ui/table-row-column "na stoku"]
                 [ui/table-row-column "8h"]
              ]
              [ui/table-row
                [ui/table-row-column "powrot"]
                 [ui/table-row-column "18:00"]
              ]]]]
       ])))

(defn avatarN []
  [ui/avatar "2"])

(defn tabel-row-passenger [])


(defn passenger-entry []
  (let [pas-name (r/atom "")]
    (fn []
      [:div {:style {:padding "5px"
                     :display "flex"
                     :justify-content "space-between"
                      :align-items "center"}}
                  [ui/text-field {:hint-text "wpisz imię"
                                  :floating-label-text "pasażer 3"
                                   :type "text"
                                   :value @pas-name
                                   :on-change #(reset! pas-name (-> % .-target .-value))
                                  :on-save #(when (seq %)
                                              (dispatch [:add-passenger %]))}]
                  [ui/floating-action-button {:mini true
                                              :primary true
                                              :on-click #(when (seq @pas-name)
                                                             (dispatch [:add-passenger @pas-name]))}
                    [ic/content-add]]])))

(defn car-card []
  (let []
    (fn []
      [ui/card {:style {:margin "10px 0px"}}
        [:div.destination {:style {:padding "5px"
                        :display "flex"
                        :justify-content "space-between"
                       :align-items "center"}}
           [ui/card-title {:title "VW T4"
                          :subtitle (str "czerwony" ", " "Blueberry Machine" ", " "miejsc razem " "5")
                          :style {:padding "5px"}}]
           ;(avatarN)
          [ui/badge {:badge-content "3"
                     :primary true
                      :style {:display "flex"
                     ;:flex-grow "2"
                     :padding "12px 12px 12px 12px"}}
            [ui/avatar {:color (color :deepOrange300)
                        :backgroundcolor (color :purple500)
                        ;:size "80"
                        :margin "0px"
                        :children "2"
                         }
              ]]
          ]
        [ui/divider]
        [ui/card-text
          [ui/table ;{:display-row-checkbox false}
             [ui/table-header {:display-select-all false
                              :adjust-for-checkbox false}
              [ui/table-row
                [ui/table-header-column "imię"]
                [ui/table-header-column "status"]]]
            [ui/table-body {:display-row-checkbox false}
              [ui/table-row
                [ui/table-row-column "Jurek"]
                 [ui/table-row-column "kierowca"]
              ]
              [ui/table-row
                [ui/table-row-column "Olek"]
                 [ui/table-row-column "pasażer 1"]
              ]
              [ui/table-row
                [ui/table-row-column "Magda"]
                 [ui/table-row-column "pasażer 2"]
              ]

            ]

          ]
           [passenger-entry]

        ]
       ])))



(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]

     ;[:div [:h1 (str "Hello from " @name ". This is the Home Page.")]
     [ui/mui-theme-provider {:mui-theme (get-mui-theme
                                         ;(aget js/MaterialUIStyles "DarkRawTheme")
                                         )}
         [:div
           [app-bar]
           ;[jumbotron]

          [destination-card]
           [car-card]
          [:a {:href "#/about"} "go to About Page"]


        ]
      ]
     ))


;; about

(defn about-panel []
  [:div "This is the About Page."
   [:div [:a {:href "#/"} "go to Home Page"]]])


;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
